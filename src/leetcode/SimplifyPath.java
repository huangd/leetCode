package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 3/10/13
 * Time: 6:26 PM
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> pathStack = new Stack<String>();
        String[] folders = path.split("/");
        for (String folder : folders) {
            if (folder.equals(".") || folder.equals("")) {
                continue;
            } else if (folder.equals("..")) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else {
                pathStack.push(folder);
            }
        }
        return stackToPath(pathStack);
    }

    private String stackToPath(Stack<String> stack) {
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop()).insert(0, "/");
        }
        return stringBuilder.toString();
    }
}
