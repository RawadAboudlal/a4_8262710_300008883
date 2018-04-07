// Student name: Rawad Aboudlal
// Student number: 8262710
// Course code: ITI 1121-C

// Assignment: #4

/**
 * <p>
 * Custom string buffer that can be used to create large strings without the
 * overhead of typical string creation; i.e. without having to create a new
 * <code>String</code> object every time a <code>String</code> needs to be
 * appended.
 * </P>
 * <p>
 * This class uses a {@link SinglyLinkedList} to hold all the characters of all
 * the added strings.
 * </p>
 * <p>
 * This class uses a temporary <code>String</code> to store the result of
 * {@link #toString()}, which will be returned instead of recreating the
 * <code>String</code> from all the characters each time the method is called.
 * Note that this <code>String</code> does need to be generated the first time
 * after the {@link #append(String)} method is called.
 * </p>
 * 
 * @author Rawad Aboudlal (rabou017@uottawa.ca)
 *
 */
public class ITIStringBuffer {

    private SinglyLinkedList<Character> charList;

    private String tempString;

    public ITIStringBuffer() {

	charList = new SinglyLinkedList<Character>();

	tempString = null;

    }

    /**
     * Constructor for this {@link ITIStringBuffer} that is initialized containing
     * <code>firstString</code>.
     * 
     * @param firstString
     *            The <code>String</code> with which this {@link ITIStringBuffer}
     *            should be initialized with.
     */
    public ITIStringBuffer(String firstString) {
	this();

	this.append(firstString);

    }

    /**
     * Appends the <code>String nextString</code> to this {@link ITIStringBuffer}.
     * 
     * @param nextString
     *            The <code>String</code> to append.
     */
    public void append(String nextString) {

	tempString = null;

	for (int i = 0; i < nextString.length(); i++) {
	    charList.add(nextString.charAt(i));
	}

    }

    /**
     * Generates a {@link String} object from the <code>character</code> information
     * stored in the {@link #charList}. This method stores the generated
     * <code>String</code> in {@link #tempString} to allow for minimum regeneration
     * time. Note that {@link #tempString} is reset to null in the
     * {@link #append(String)} method.
     * 
     * @see java.lang.Object#toString()
     * @see ITIStringBuffer#append(String)
     */
    @Override
    public String toString() {

	if (tempString == null) {

	    char[] rawChars = new char[charList.size()];

	    int i = 0;

	    for (char c : charList) {
		rawChars[i++] = c;
	    }

	    tempString = new String(rawChars);

	}

	return tempString;

    }

}
