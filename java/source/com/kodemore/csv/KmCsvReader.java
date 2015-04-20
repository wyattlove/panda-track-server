/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.csv;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.string.KmString;
import com.kodemore.utility.Kmu;

/**
 * I am a simply utility to help read Comma Separated Value files.
 * See main method for example usage.
 */
public class KmCsvReader
{
    //##################################################
    //# constants
    //##################################################

    private static final char    DEFAULT_QUOTE     = '"';
    private static final char    DEFAULT_SEPARATOR = ',';

    private static final char    CR                = '\r';
    private static final char    LF                = '\n';

    //##################################################
    //# variables
    //##################################################

    private PushbackReader       _reader;
    private KmList<String>       _fields;

    /**
     * The 0-based index of the current line.
     * Return -1 if the first line has not been read yet.
     */
    private int                  _lineIndex;
    private int                  _fieldIndex;

    private char                 _quote;
    private char                 _separator;
    private KmMap<String,String> _conversions;

    //##################################################
    //# constructor
    //##################################################

    public KmCsvReader()
    {
        _lineIndex = -1;
        _separator = DEFAULT_SEPARATOR;
        _quote = DEFAULT_QUOTE;
        _fields = new KmList<>();
        _conversions = new KmMap<>();
    }

    //##################################################
    //# accessing
    //##################################################

    /**
     * Read a source; the caller is responsible for closing the reader.
     */
    public void setSource(Reader r)
    {
        _reader = new PushbackReader(r);
    }

    public void setSource(String s)
    {
        _reader = new PushbackReader(new StringReader(s));
    }

    public void setSourceFile(String path)
    {
        String s = Kmu.readFileString(path);
        setSource(s);
    }

    public char getSeparator()
    {
        return _separator;
    }

    public void setSeparator(char e)
    {
        _separator = e;
    }

    public char getQuote()
    {
        return _quote;
    }

    public void setQuote(char e)
    {
        _quote = e;
    }

    public Map<String,String> getConversions()
    {
        return _conversions;
    }

    public void setConversions(KmMap<String,String> e)
    {
        _conversions = e;
    }

    public void addConversion(String oldText, String newText)
    {
        _conversions.put(oldText, newText);
    }

    //##################################################
    //# record
    //##################################################

    /**
     * Read the next record; this must be called before the first
     * record is accessed.  Return true if a record is read, false
     * if end of file.  The reader is NOT closed automatically upon
     * end of file, you must call close.
     */
    public boolean nextRecord()
    {
        try
        {
            return _readRecord();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private boolean _readRecord() throws IOException
    {
        int i = _read();
        if ( i < 0 )
            return false;

        _lineIndex++;
        _unread(i);
        _readFields();

        return true;
    }

    private void _readFields() throws IOException
    {
        _fields.clear();
        _fieldIndex = 0;

        while ( true )
        {
            String s = _readField();
            if ( s == null )
                break;

            s = _convert(s);
            _fields.add(s);
        }

        _fields.isNotEmpty();
    }

    private String _readField() throws IOException
    {
        int i = _read();

        if ( i < 0 )
            return null;

        if ( i == LF )
            return null;

        if ( i == CR )
        {
            int lf = _read();
            if ( lf != LF )
                _unread(lf);
            return null;
        }

        _unread(i);
        if ( i == _quote )
            return _readQuotedField();

        return _readNormalField();
    }

    /**
     * Read the next field
     * May be terminated by: _separater, CR, LF, or EOF.
     * The terminating _separator, if any, is eaten.
     */
    private String _readNormalField() throws IOException
    {
        int c;
        StringBuilder out = new StringBuilder();

        while ( true )
        {
            c = _read();
            if ( c == _separator )
                break;

            if ( c < 0 )
                break;

            if ( c == CR || c == LF )
            {
                _unread(c);
                break;
            }

            out.append((char)c);
        }
        return out.toString();
    }

    /**
     * Read the next quoted field.
     * Next character must be _quote.
     * Must be terminated by: _quote.
     * The _separator immediately after the terminating quote, if any, is eaten.
     */
    private String _readQuotedField() throws IOException
    {
        int c, cc;
        StringBuilder out = new StringBuilder();
        _read();

        while ( true )
        {
            c = _read();
            if ( c < 0 )
                break;

            if ( c == _quote )
            {
                cc = _read();
                if ( cc != _quote )
                {
                    _unread(cc);
                    break;
                }
            }

            out.append((char)c);
        }

        c = _read();
        if ( c != _separator )
            _unread(c);

        return out.toString();
    }

    private String _convert(String s)
    {
        Iterator<Map.Entry<String,String>> i = _conversions.entrySet().iterator();
        while ( i.hasNext() )
        {
            Map.Entry<String,String> me = i.next();
            String oldText = me.getKey();
            String newText = me.getValue();
            s = _convert(s, oldText, newText);
        }

        return s;
    }

    private String _convert(String s, String oldText, String newText)
    {
        return Kmu.replaceAll(s, oldText, newText);
    }

    private int _read() throws IOException
    {
        return _reader.read();
    }

    private void _unread(int i) throws IOException
    {
        if ( i >= 0 )
            _reader.unread(i);
    }

    //##################################################
    //# fields
    //##################################################

    public KmString getValue(int i)
    {
        return new KmString(getString(i, null));
    }

    public KmString getValue()
    {
        return getValue(_fieldIndex++);
    }

    public String getString(int i)
    {
        return getString(i, "");
    }

    public String getString()
    {
        return getString(_fieldIndex++);
    }

    public String getString(String def)
    {
        return getString(_fieldIndex++, def);
    }

    public String getString(int i, String def)
    {
        if ( !isValidField(i) )
            return def;
        return _fields.get(i);
    }

    public int getInteger(int i)
    {
        return getInteger(i, Integer.MIN_VALUE);
    }

    public int getInteger()
    {
        return getInteger(_fieldIndex++);
    }

    public int getInteger(int i, int def)
    {
        if ( !isValidField(i) )
            return def;

        String s = getString(i);
        return Kmu.parse_int(s, def);
    }

    public double getDouble(int i)
    {
        return getDouble(i, Double.NaN);
    }

    public double getDouble()
    {
        return getDouble(_fieldIndex++);
    }

    public double getDouble(int i, double def)
    {
        if ( !isValidField(i) )
            return def;

        String s = getString(i);
        return Kmu.parse_double(s, def);
    }

    public boolean getBoolean(int i)
    {
        return getBoolean(i, false);
    }

    public boolean getBoolean()
    {
        return getBoolean(_fieldIndex++);
    }

    public boolean getBoolean(int i, boolean def)
    {
        if ( !isValidField(i) )
            return def;

        String s = getString(i);
        return Kmu.parse_boolean(s, def);
    }

    public Boolean getBooleanObject(int i)
    {
        return getBooleanObject(i, null);
    }

    public Boolean getBooleanObject(int i, Boolean def)
    {
        if ( !isValidField(i) )
            return def;

        String s = getString(i);
        return Kmu.parseBoolean(s, def);
    }

    public int getFieldCount()
    {
        return _fields.size();
    }

    public boolean isValidField(int i)
    {
        return getFieldCount() > i;
    }

    public int getLineIndex()
    {
        return _lineIndex;
    }

}
