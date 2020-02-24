/**
 * Created by Chris Renfrow on 2019-08-28.
 */

package com.example.chatroom.extension

import android.content.Context
import android.text.Spanned
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

fun Context.getHtmlSpannedString(@StringRes id: Int): Spanned = getString(id).toHtmlSpan()

fun Context.getHtmlSpannedString(@StringRes id: Int, vararg formatArgs: Any): Spanned = getString(
    id,
    *formatArgs
).toHtmlSpan()

fun Context.getQuantityHtmlSpannedString(@PluralsRes id: Int, quantity: Int): Spanned =
    resources.getQuantityString(
        id,
        quantity
    ).toHtmlSpan()

fun Context.getQuantityHtmlSpannedString(
    @PluralsRes id: Int, quantity: Int,
    vararg formatArgs: Any
): Spanned = resources.getQuantityString(
    id,
    quantity,
    *formatArgs
).toHtmlSpan()