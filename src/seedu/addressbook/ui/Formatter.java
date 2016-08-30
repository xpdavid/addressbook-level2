package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

public class Formatter {
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
	
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    
    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /**
     * Generates message for asking user for input
     * 
     * @return message in string
     */
    public static String formatMessageEnterCommandText() {
        return LINE_PREFIX + "Enter command: ";
    }

    /**
     * Generates message when receiving command
     * 
     * @param command in string
     * @return message in string
     */
    public static String formatMessageReceiveCommandText(String command) {
        return formatOutputToText("[Command entered:" + command + "]");
    }

    /**
     * Generates welcome message
     * 
     * @param version version of the software
     * @param storageFilePath location of storage file
     * @return message in string
     */
    public static String formatMessageWelcomeText(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return formatOutputToText(
                    DIVIDER,
                    DIVIDER,
                    MESSAGE_WELCOME,
                    version,
                    MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                    storageFileInfo,
                    DIVIDER
                );
    }

    /**
     * Generates goodbye message
     * 
     * @return message in string
     */
    public static String formatMessageGoodbyeText() {
        return formatOutputToText(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    /**
     * Generates init fail message
     * 
     * @return message in string
     */
    public static String formatMessageInitFailText() {
        return formatOutputToText(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     * Generates feedback message
     * 
     * @param feedbackToUser
     * @return message in string
     */
    public static String formatFeedback(String feedbackToUser) {
        return formatOutputToText(feedbackToUser, DIVIDER);
    }
 
    /**
     * Generates output message with LINE_PREFIX at the beginning of each line
     * 
     * @param message
     * @return
     */
    public static String formatOutputToText(String... message) {
        StringBuffer outputs = new StringBuffer();
        for (String m : message) {
            outputs.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX) + LS);    
        }
        return outputs.toString();
    }

    /**
     * generates message for indexed list
     * 
     * @param listItems
     * @return
     */
	public static String formatIndexedListToText(List<String> listItems) {
		final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(Formatter.formatMessageIndexedItemText(displayIndex, listItem));
            displayIndex++;
        }
        return Formatter.formatOutputToText(formatted.toString());
	}
	
	/**
     * Generates message for indexed item
     * 
     * @param visibleIndex
     * @param listItem
     * @return message in string
     */
    public static String formatMessageIndexedItemText(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem) + '\n';
    }


}
