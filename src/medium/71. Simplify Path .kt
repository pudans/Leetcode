package medium

import StackTopic
import StringTopic
import java.util.*

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 *
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.
 */

class Medium71 : StringTopic, StackTopic {

    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        var start = -1
        for (i in 0..path.length) {
            if (i == path.length || path[i] == '/') {
                if (start > 0) {
                    when (val dir = path.substring(start, i)) {
                        "." -> Unit
                        ".." -> if (stack.isNotEmpty()) stack.pop()
                        else -> stack.add(dir)
                    }
                    start = -1
                }
            } else {
                if (start < 0) start = i
            }
        }
        return stack.joinToString("/", "/")
    }
}

fun main() {
    println(Medium71().simplifyPath("/home/")) // /home
    println(Medium71().simplifyPath("/../")) // /
    println(Medium71().simplifyPath("/home//foo/")) // /home/foo
    println(Medium71().simplifyPath("/a/./b/../../c/")) // /c
    println(Medium71().simplifyPath("/...")) // /
}