package main.java.exercitii;
import java.io.*;
import java.util.*;
import java.util.stream.*;
/*
Statement
Implement a mock up method for a recycle bin.

The input consists of a single string argument containing a list of all file paths in a file system followed by a list of remove and restore commands.

Print the list of file paths marked for removal after applying the provided commands.


Notes
Empty input lines are ignored
Commands on a directory mark all files contained in that directory's tree, recursively
Commands on non-existent files or directories have no effect
'/' and '\' can be used interchangeably as separators (/foo\bar/baz is the same as \foo\bar/baz)
Any sequence of forward or back slashes is equivalent to a single separator (//foo///bar//\\/baz is the same as (/foo/bar/baz)
Any trailing '/' or '\' is redundant (/foo/bar/ is the same as /foo/bar)
'.' and '..' have no special meaning
The remove and restore commands can be followed by one or more space ' ' characters
 */
public class ex1_eda_amiq {
    public static void main(String[] args) throws IOException {
        // Reading input in the field input
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        String input = inputBuffer.lines().collect(Collectors.joining("\n"));

        String result = null;

        // This is a debug message
        System.err.println(input);

        /*
        Implement a mock up method for a recycle bin.

The input consists of a single string argument containing a list of all file paths in a file system followed by a list of remove and restore commands.

Print the list of file paths marked for removal after applying the provided commands.
         */

        /*
/home/user_008/candies
/home/user_008/sleeping_pills
/home/user_008/keys

remove /home/user_008/sleeping_pills
         */
        String[] lines = input.split("\n");
        List<String> files = new ArrayList<String>();
        List<String> command = new ArrayList<String>();

        int check = 0;
        for(String index : lines){
            System.out.println(index);
            if(index == ""){
                        check = 1;
                continue;
            }
            if(check == 1){
                command.add(index);
            }else{
                files.add(index);
            }
        }
        System.out.println(files);
//        // Write your code here
//        String[] lines = input.split("\n");
//        System.out.println(Arrays.toString(lines));
//        String[] files = lines[0].split(" ");
//        String[] commands = Arrays.copyOfRange(lines, 1, lines.length);
//        List<String> filesList = new ArrayList<String>(Arrays.asList(files));
//        List<String> commandsList = new ArrayList<String>(Arrays.asList(commands));
//        List<String> filesToRemove = new ArrayList<String>();
//        List<String> filesToRestore = new ArrayList<String>();
//        for(String command : commandsList){
//            if(command.startsWith("remove")){
//                String[] commandSplit = command.split(" ");
//                String file = commandSplit[1];
//                if(filesList.contains(file)){
//                    filesToRemove.add(file);
//                }
//                else{
//                    for(String fileInList : filesList){
//                        if(fileInList.startsWith(file)){
//                            filesToRemove.add(fileInList);
//                        }
//                    }
//                }
//            }
//            else if(command.startsWith("restore")){
//                String[] commandSplit = command.split(" ");
//                String file = commandSplit[1];
//                if(filesToRemove.contains(file)){
//                    filesToRestore.add(file);
//                }
//                else{
//                    for(String fileInList : filesToRemove){
//                        if(fileInList.startsWith(file)){
//                            filesToRestore.add(fileInList);
//                        }
//                    }
//                }
//            }
//        }
//        filesToRemove.removeAll(filesToRestore);
//        Collections.sort(filesToRemove);
//        result = String.join(" ", filesToRemove);
//
//
//
//
//        // Print result
//        System.out.println(result);

    }
}
