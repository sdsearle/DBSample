/**
 * Created by Chris Renfrow on 4/17/18.
 */

package com.example.chatroom.extension

import android.os.Build
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan


fun String.replaceLast(
    oldValue: String,
    newValue: String,
    ignoreCase: Boolean = false
): String {

    val index = this.lastIndexOf(oldValue, ignoreCase = ignoreCase)

    var newString = this
    if (index >= 0) {
        newString = "${newString.substring(
            0,
            index
        )}$newValue${newString.substring(index + oldValue.length)}"
    }

    return newString
}

fun String.isValidEmail(): Boolean {
    val pattern = "^.*@.+\\..+$"

    return matches(pattern.toRegex())
}

fun String.isValidPhone(): Boolean {
    val pattern = "^\\d{10}$"

    return matches(pattern.toRegex())
}

fun String.underscoreToWords(): String = replace("_", " ")

fun String.toTitleCase(): String {
    var capNext = true
    val sb = StringBuilder()

    this.toCharArray().forEach {
        val c = if (capNext) Character.toUpperCase(it) else Character.toLowerCase(it)
        sb.append(c)
        capNext = Character.isSpaceChar(it)
    }

    return sb.toString()
}

fun String.toPascalCase(): String {
    var capNext = true
    val sb = StringBuilder()

    this.toCharArray().forEach {
        capNext = if (it != ' ') {
            val c = if (capNext) Character.toUpperCase(it) else Character.toLowerCase(it)
            sb.append(c)
            false
        } else {
            true
        }
    }

    return sb.toString()
}

fun String.colorPhoneNumber(color: Int): CharSequence {
    val pattern = "(\\+?\\d ?)?(\\(?\\d{3}\\)? ?)? ?-? ?\\d{3} ?-? ?\\d{4}".toRegex()

    val phoneNumber = pattern.find(this)?.value

    return phoneNumber?.let { colorSubstring(phoneNumber, color) } ?: this
}

fun String.colorSubstring(substring: String, color: Int): CharSequence {
    val spannable = SpannableString(this)
    var substringStart = 0
    var start: Int
    while (this.indexOf(substring, substringStart).also { start = it } >= 0) {
        spannable.setSpan(
            ForegroundColorSpan(color), start, start + substring.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        substringStart = start + substring.length
    }

    return spannable
}

@Suppress("DEPRECATION")
fun String.toHtmlSpan(): Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
    Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
else
    Html.fromHtml(this)