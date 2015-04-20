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

package com.kodemore.stf;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.log.KmLog;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * I am used to parse the stf format.  Structured Text Files.
 */
public class KmStfParser
    implements KmStfConstantsIF, KmConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The original source being parsed.
     */
    private String                _source;

    /**
     * The folder where the source is assumed to live.  This is
     * not required and the parser can be used to simple parse
     * freeform strings.  However, the #include command needs to
     * know where this folder lives.
     */
    private KmFile                _includeFolder;

    /**
     * The normalized lines being parsed.
     * Lines are normalized by doing things like
     * trimming trailing whitespace and converting
     * tabs to spaces.  See normalize method below.
     */
    private KmList<String>        _lines;

    /**
     * The 0-based index of the line currently being
     * parsed.
     */
    private int                   _index;

    /**
     * Using tabs is not recommended, but is supported by
     * converting each tab to a specified number of spaces.
     * Must be set to a value >= 1; defaults to 4.
     */
    private int                   _tabSpaces;

    /**
     * The list of prefixes that identify single line comments.
     * The default values include:
     *      java-style: //
     */
    private KmList<String>        _singleLineCommentsPatterns;

    /**
     * The list of prefixes and suffixes that delimit multiline
     * comments.  Multiline comments must start at the start
     * of a line, and end at the end of a line (not counting
     * whitespace).
     *
     * The following multiline comments are installed
     * by default.  Additional patterns may be added
     * or the defaults may be cleared.
     *
     *      java-style: slash-star ... star-slash
     *      html-style: <!-- ... -->
     *
     */
    private KmMap<String,String>  _multiLineCommentPatterns;

    /**
     * Shortcuts can be used to convert element arguments
     * into attributes.
     */
    private KmList<KmStfShortcut> _shortcuts;

    /**
     * A container for the results.
     */
    private KmStfRoot             _root;

    //##################################################
    //# constructor
    //##################################################

    public KmStfParser()
    {
        _tabSpaces = 4;
        _singleLineCommentsPatterns = new KmList<>();
        _multiLineCommentPatterns = new KmMap<>();
        _shortcuts = new KmList<>();

        installDefaults();
    }

    private void installDefaults()
    {
        addSingleLineCommentPattern("//");

        addMutliLineCommentPattern("/*", "*/");
        addMutliLineCommentPattern("<!--", "-->");
    }

    //##################################################
    //# setup
    //##################################################

    public void setTabSpaces(int e)
    {
        _tabSpaces = e;
    }

    public int getTabSpaces()
    {
        return _tabSpaces;
    }

    public KmList<String> getSingleLineCommentPatterns()
    {
        return _singleLineCommentsPatterns;
    }

    public void addSingleLineCommentPattern(String prefix)
    {
        _singleLineCommentsPatterns.add(prefix);
    }

    public void clearSingleLineCommentPatterns()
    {
        _singleLineCommentsPatterns.clear();
    }

    public KmMap<String,String> getMultiLineCommentPatterns()
    {
        return _multiLineCommentPatterns;
    }

    public void addMutliLineCommentPattern(String prefix, String suffix)
    {
        _multiLineCommentPatterns.put(prefix, suffix);
    }

    public void clearMutliLineCommentPatterns()
    {
        _multiLineCommentPatterns.clear();
    }

    public KmList<KmStfShortcut> getShortcuts()
    {
        return _shortcuts;
    }

    public KmStfShortcut getDefaultShortcut()
    {
        for ( KmStfShortcut e : getShortcuts() )
            if ( e.isDefaultArgument() )
                return e;

        return null;
    }

    public KmList<KmStfShortcut> getPrefixShortcuts()
    {
        KmList<KmStfShortcut> v = new KmList<>();

        for ( KmStfShortcut e : getShortcuts() )
            if ( e.hasArgumentPrefix() )
                v.add(e);

        return v;
    }

    public void addShortcut(KmStfShortcut e)
    {
        _shortcuts.add(e);
    }

    public KmStfShortcut addShortcut()
    {
        KmStfShortcut e;
        e = new KmStfShortcut();

        addShortcut(e);

        return e;
    }

    public KmStfShortcut addPrefixShortcut(String key, String prefix)
    {
        KmStfShortcut e;
        e = addShortcut();
        e.setAttributeKey(key);
        e.setArgumentPrefix(prefix);
        return e;
    }

    public KmStfShortcut addDefaultShortcut(String key)
    {
        KmStfShortcut e;
        e = addShortcut();
        e.setAttributeKey(key);
        return e;
    }

    public void setIncludeFolder(String e)
    {
        if ( e == null )
            clearIncludeFolder();
        else
            setIncludeFolder(new KmFile(e));
    }

    public void setIncludeFolder(KmFile e)
    {
        _includeFolder = e;
    }

    public KmFile getIncludeFolder()
    {
        return _includeFolder;
    }

    public boolean hasIncludeFolder()
    {
        return _includeFolder != null;
    }

    public void clearIncludeFolder()
    {
        _includeFolder = null;
    }

    //##################################################
    //# parse
    //##################################################

    public void parseSource(String s)
    {
        parse(s);
    }

    public void parseFile(String path)
    {
        KmFile file = new KmFile(path);
        parseFile(file);
    }

    public void parseFile(KmFile file)
    {
        KmFile folder = file.getParent();
        String src = file.readString();

        setIncludeFolder(folder);
        parseSource(src);
    }

    public KmStfRoot getRoot()
    {
        return _root;
    }

    //##################################################
    //# private
    //##################################################

    private void parse(String s)
    {
        _source = s;
        _index = 0;
        _root = new KmStfRoot();

        initLines();
        warnOnTabs();

        while ( !eof() )
            parseLine();
    }

    private void parseLine()
    {
        if ( eof() )
            return;

        if ( parseCommand() )
            return;

        if ( parseComment() )
            return;

        if ( parseStringElement() )
            return;

        if ( parseAttribute() )
            return;

        parseElement();
    }

    //##################################################
    //# commands
    //##################################################

    private boolean parseCommand()
    {
        String line = getLine().trim();
        if ( !line.startsWith(COMMAND_PREFIX) )
            return false;

        String cmd = "";
        String detail = "";

        line = Kmu.removePrefix(line, COMMAND_PREFIX);

        int i = line.indexOf(SPACE);
        if ( i < 0 )
            cmd = line;
        else
        {
            cmd = line.substring(0, i);
            detail = line.substring(i).trim();
        }

        if ( parseInclude(cmd, detail) )
            return true;

        throw newParseError("Unknown command (%s).", cmd);
    }

    private boolean parseInclude(String cmd, String detail)
    {
        if ( !cmd.equals("include") )
            return false;

        if ( !hasIncludeFolder() )
            throw newParseError("Cannot include; no folder specified.");

        KmFile folder = getIncludeFolder();
        KmFile file = folder.getChild(detail);

        if ( !file.exists() )
            throw newParseError("Include file not found: %s.", file);

        nextLine();

        KmList<String> lines = file.readLines();
        addLines(lines);

        return true;
    }

    //##################################################
    //# parse comments
    //##################################################

    private boolean parseComment()
    {
        if ( parseBlankLine() )
            return true;

        if ( parseSingleLineComment() )
            return true;

        if ( parseMultiLineComment() )
            return true;

        return false;
    }

    private boolean parseBlankLine()
    {
        String s = getLine();
        boolean isEmpty = Kmu.isEmpty(s);

        if ( !isEmpty )
            return false;

        nextLine();
        return true;
    }

    private boolean parseSingleLineComment()
    {
        KmList<String> v = _singleLineCommentsPatterns;

        for ( String prefix : v )
            if ( parseSingleLineComment(prefix) )
                return true;

        return false;
    }

    private boolean parseSingleLineComment(String prefix)
    {
        String s = getLine().trim();

        if ( !s.startsWith(prefix) )
            return false;

        nextLine();
        return true;
    }

    private boolean parseMultiLineComment()
    {
        KmList<String> prefixes = _multiLineCommentPatterns.getKeys();
        for ( String prefix : prefixes )
        {
            String suffix = _multiLineCommentPatterns.get(prefix);

            if ( parseMultiLineComment(prefix, suffix) )
                return true;
        }

        return false;
    }

    private boolean parseMultiLineComment(String prefix, String suffix)
    {
        int startLine = _index;
        boolean isComment = getLine().trim().startsWith(prefix);

        if ( !isComment )
            return false;

        while ( true )
        {
            if ( getLine().endsWith(suffix) )
            {
                nextLine();
                return true;
            }

            nextLine();

            if ( eof() )
                throw newParseError(startLine, "Comment not terminated.");
        }
    }

    //##################################################
    //# parse attribute
    //##################################################

    private boolean parseAttribute()
    {
        String prefix = ATTRIBUTE_PREFIX;

        String line;

        line = getLine().trim();
        if ( !line.startsWith(prefix) )
            return false;

        KmStfElement tail = getTail();
        if ( tail == null )
            throw newParseError("Attribute found, but no parent element.");

        if ( !tail.hasIndent(getIndent()) )
            throw newParseError("Attribute indent must match parent element.");

        if ( _parseSingleLineAttribute() )
            return true;

        if ( _parseMultiLineAttribute() )
            return true;

        if ( _parseSimpleAttribute() )
            return true;

        throw newParseError("Cannot parse attribute.");
    }

    private boolean _parseSingleLineAttribute()
    {
        String prefix = ATTRIBUTE_PREFIX;
        String assign = ATTRIBUTE_ASSIGN;

        String line;
        line = getLine().trim();
        line = Kmu.removePrefix(line, prefix).trim();

        int i = line.indexOf(assign);
        if ( i < 0 )
            return false;

        String key = line.substring(0, i).trim();
        String value = line.substring(i + 1).trim();

        validateAttributeKey(key);

        getTail().addAttribute(key, value);
        nextLine();

        return true;
    }

    private boolean _parseMultiLineAttribute()
    {
        String prefix = ATTRIBUTE_PREFIX;
        String cont = ATTRIBUTE_CONTINUE;

        String line;
        line = getLine().trim();
        line = Kmu.removePrefix(line, prefix).trim();

        int i = line.indexOf(cont);
        if ( i < 0 )
            return false;

        String key = line.substring(0, i).trim();
        String value = line.substring(i + cont.length()).trim();

        validateAttributeKey(key);

        if ( Kmu.hasValue(value) )
            throw newParseError("Attribute value should be moved to next line.");

        nextLine();

        KmStfElement string = parseString();
        if ( string == null )
            throw newParseError("Attribute value not found on next line.");

        KmStfElement tail = getTail();
        if ( string.getIndent() <= tail.getIndent() )
            throw newParseError("Attribute value not indented.");

        tail.addAttribute(key, string.getValue(STRING_ATTRIBUTE_KEY));

        return true;
    }

    private boolean _parseSimpleAttribute()
    {
        String prefix = ATTRIBUTE_PREFIX;

        String line;
        line = getLine().trim();
        line = Kmu.removePrefix(line, prefix).trim();

        if ( line.contains(SPACE) )
            return false;

        String key = line;
        String value = null;

        validateAttributeKey(key);

        getTail().addAttribute(key, value);
        nextLine();

        return true;
    }

    private void validateAttributeKey(String key)
    {
        if ( key.contains(SPACE) )
            throw newParseError("Attribute key cannot contain whitespace.");
    }

    //##################################################
    //# parse element
    //##################################################

    /**
     * Anything not already parsed is assumed to be a
     * new element.  We throw an error if the element cannot
     * be parsed.
     */
    private void parseElement()
    {
        String line = getLine().trim();
        char c = line.charAt(0);

        if ( !Kmu.isLetter(c) )
            throw newParseError("Elements must start with a letter.");

        KmStfElement parent = null;
        int indent = getIndent();

        KmList<String> tokens = Kmu.tokenize(line, CHAR_DOT);
        for ( String token : tokens )
        {
            String name = token;
            KmList<String> args = null;

            int i = token.indexOf(OPEN_PAREN);
            if ( i >= 0 )
            {
                if ( !token.endsWith(CLOSE_PAREN) )
                    throw newParseError("Element arguments not terminated.");

                name = token.substring(0, i);

                String s = token.substring(i + 1, token.length() - 1);
                args = Kmu.tokenize(s, CHAR_SPACE);
            }

            KmStfElement child;
            child = new KmStfElement();
            child.setName(name);
            child.setIndent(indent);

            if ( parent == null )
                addChild(child);
            else
                parent.addChild(child);

            applyArguments(child, args);

            parent = child;
        }

        nextLine();
    }

    private void applyArguments(KmStfElement e, KmList<String> args)
    {
        if ( args == null )
            return;

        for ( String arg : args )
            applyArgument(e, arg);
    }

    private void applyArgument(KmStfElement e, String arg)
    {
        if ( applyPrefixShortcuts(e, arg) )
            return;

        if ( applyDefaultShortcut(e, arg) )
            return;

        throw newParseError("Cannot parse argument %s.", arg);
    }

    private boolean applyPrefixShortcuts(KmStfElement e, String arg)
    {
        KmList<KmStfShortcut> v = getPrefixShortcuts();

        for ( KmStfShortcut sc : v )
            if ( sc.applyTo(e, arg) )
                return true;

        return false;
    }

    private boolean applyDefaultShortcut(KmStfElement e, String arg)
    {
        KmStfShortcut sc = getDefaultShortcut();
        if ( sc == null )
            throw newParseError("Cannot parse argument %s.", arg);

        return sc.applyTo(e, arg);
    }

    //##################################################
    //# parse string
    //##################################################

    private boolean parseStringElement()
    {
        KmStfElement e = parseString();
        if ( e == null )
            return false;

        addChild(e);
        return true;
    }

    private KmStfElement parseString()
    {
        KmStfElement e;

        e = parseMultiLineString();
        if ( e != null )
            return e;

        e = parseSingleLineString();
        if ( e != null )
            return e;

        return null;
    }

    private KmStfElement parseSingleLineString()
    {
        KmStfElement e;

        e = parseSingleLineString(STRING_TICK);
        if ( e != null )
            return e;

        e = parseSingleLineString(STRING_QUOTE);
        if ( e != null )
            return e;

        return null;
    }

    private KmStfElement parseSingleLineString(String delim)
    {
        String prefix = delim;
        String suffix = delim;

        String line = getLine().trim();
        int indent = getIndent();

        if ( !line.startsWith(prefix) )
            return null;

        if ( !line.endsWith(suffix) )
            throw newParseError("String literal not terminated.");

        line = Kmu.removePrefix(line, prefix);
        line = Kmu.removeSuffix(line, suffix);

        nextLine();

        return newText(indent, line);
    }

    private KmStfElement parseMultiLineString()
    {
        KmStfElement e;

        e = parseMultiLineString(STRING_DASHES, " ");
        if ( e != null )
            return e;

        e = parseMultiLineString(STRING_EQUALS, "\n");
        if ( e != null )
            return e;

        return null;
    }

    private KmStfElement parseMultiLineString(String quote, String split)
    {
        String prefix = quote;
        String suffix = quote;

        int indent = getIndent();

        String line;
        line = getLine().trim();

        if ( !line.equals(prefix) )
            return null;

        KmStringBuilder out = new KmStringBuilder();

        while ( true )
        {
            nextLine();

            if ( eof() )
                throw newParseError("Multiline string not terminated.");

            if ( getIndent() < indent )
                throw newParseError("Multiline string cannot indent less than first line.");

            line = getLine().trim();

            if ( line.equals(suffix) )
            {
                if ( getIndent() != indent )
                    throw newParseError("Muliline string suffix should align with prefix.");

                nextLine();
                break;
            }

            line = getLine().substring(indent);

            if ( out.isNotEmpty() )
                out.append(split);

            out.append(line);
        }

        return newText(indent, out.toString());
    }

    private KmStfElement newText(int indent, String line)
    {
        KmStfElement e;
        e = new KmStfElement();
        e.setName(STRING_ELEMENT_NAME);
        e.setIndent(indent);
        e.addAttribute(STRING_ATTRIBUTE_KEY, line);
        return e;
    }

    //##################################################
    //# support
    //##################################################

    private void initLines()
    {
        _lines = new KmList<>();

        KmList<String> v = Kmu.parseLines(_source);
        for ( String e : v )
            _lines.add(normalizeLine(e));
    }

    private String normalizeLine(String s)
    {
        String spaces = Kmu.repeat(CHAR_SPACE, _tabSpaces);

        s = Kmu.replaceAll(s, CHAR_TAB, spaces);
        s = Kmu.trimTrailing(s);

        return s;
    }

    private KmList<String> normalizeLines(KmList<String> in)
    {
        KmList<String> out = new KmList<>();

        for ( String e : in )
            out.add(normalizeLine(e));

        return out;
    }

    private void warnOnTabs()
    {
        if ( _source.contains(TAB) )
            warn("Found tab characters, replaced with spaces.");
    }

    private boolean eof()
    {
        return _lines.isOutOfBounds(_index);
    }

    private void nextLine()
    {
        _index++;
    }

    private String getLine()
    {
        return getLine(_index);
    }

    private String getLine(int i)
    {
        return _lines.get(i);
    }

    private void addLines(KmList<String> v)
    {
        _lines.addAll(_index, normalizeLines(v));
    }

    private int getIndent()
    {
        String s = getLine();

        int i = 0;
        int n = s.length();

        while ( true )
        {
            if ( i >= n )
                break;

            char c = s.charAt(i);
            if ( c != CHAR_SPACE )
                break;

            i++;
        }

        return i;
    }

    private KmStfElement getTail()
    {
        KmStfElement e = _root.getChildren().getLastSafe();
        if ( e == null )
            return null;

        while ( e.hasChildren() )
            e = e.getChildren().getLast();

        return e;
    }

    private void addChild(KmStfElement child)
    {
        KmStfElement parent = getTail();

        while ( true )
        {
            if ( parent == null )
                break;

            if ( parent.getIndent() < child.getIndent() )
                break;

            parent = parent.getParent();
        }

        if ( parent == null )
            _root.addChild(child);
        else
            parent.addChild(child);
    }

    //##################################################
    //# log
    //##################################################

    private void warn(String msg, Object... args)
    {
        KmLog.warn(msg, args);
    }

    private RuntimeException newParseError(String msg, Object... args)
    {
        return newParseError(_index, msg, args);
    }

    private RuntimeException newParseError(int index, String msg, Object... args)
    {
        KmStfError ex;
        ex = new KmStfError(msg, args);
        ex.setLineText(getLine(index));
        ex.setLineNumber(index + 1);
        throw ex;
    }
}
