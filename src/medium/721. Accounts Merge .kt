package medium

import ArraysTopic
import BFSTopic
import DFSTopic
import UnionFindTopic
import java.util.*


/**
 * 721. Accounts Merge
 * https://leetcode.com/problems/accounts-merge/
 *
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
and the rest of the elements are emails representing emails of the account.
Now, we would like to merge these accounts.
Two accounts definitely belong to the same person if there is some common email to both accounts.
Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format: the first element of each account is the name,
and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 BULLSHIT
 */

class Medium721 : ArraysTopic, DFSTopic, BFSTopic, UnionFindTopic {

    fun accountsMerge1(accounts: List<List<String>>): List<List<String>> {

        val map = HashMap<String, ArrayList<String>>()

        for (i in 0 until accounts.size - 1) {
            val name = accounts[i].first()
            if (map.contains(name)) continue
            var newAccounts = ArrayList<String>()

            for (j in i + 1 until accounts.size) {
                val otherName = accounts[j].first()
                if (name == otherName) {

                }
            }
            map[name] = newAccounts
        }

        return map.map {
            it.value.add(0, it.key)
            it.value
        }
    }


    var visited = HashSet<String>()
    var adjacent: MutableMap<String, MutableList<String>> = HashMap()

    private fun DFS(mergedAccount: MutableList<String>, email: String) {
        visited.add(email)
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email)
        if (!adjacent.containsKey(email)) {
            return
        }
        for (neighbor in adjacent[email]!!) {
            if (!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor)
            }
        }
    }

    fun accountsMerge(accountList: List<List<String>>): List<List<String>> {
        for (account in accountList) {
            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            val accountFirstEmail = account[1]
            for (j in 2 until account.size) {
                val accountEmail = account[j]
                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent[accountFirstEmail] = ArrayList()
                }
                adjacent[accountFirstEmail]!!.add(accountEmail)
                if (!adjacent.containsKey(accountEmail)) {
                    adjacent[accountEmail] = ArrayList()
                }
                adjacent[accountEmail]!!.add(accountFirstEmail)
            }
        }

        // Traverse over all th accounts to store components
        val mergedAccounts = ArrayList<List<String>>()
        for (account in accountList) {
            val accountName = account[0]
            val accountFirstEmail = account[1]

            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                val mergedAccount: MutableList<String> = ArrayList()
                // Adding account name at the 0th index
                mergedAccount.add(accountName)
                DFS(mergedAccount, accountFirstEmail)
                mergedAccount.subList(1, mergedAccount.size).sort()
                mergedAccounts.add(mergedAccount)
            }
        }
        return mergedAccounts
    }
}

fun main() {

}