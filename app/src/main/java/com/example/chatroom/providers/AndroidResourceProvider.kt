/**
 * Created by Chris Renfrow on 1/30/18.
 */

package com.example.chatroom.providers

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Spanned
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatroom.BaseApplication
import com.example.chatroom.extension.getHtmlSpannedString
import javax.inject.Inject
import kotlin.math.roundToInt

class AndroidResourceProvider @Inject constructor(val context: Context) : ColorProvider,
    DrawableProvider,
    IntegerProvider,
    DimenProvider,
    LayoutManagerProvider,
    StringProvider {

    //-------------------------------------------
    // region ColorProvider Overrides
    //-------------------------------------------

    override fun getColor(@ColorRes resID: Int): Int {
        return BaseApplication.currentActivity?.let {
            ContextCompat.getColor(it, resID)
        } ?: Color.TRANSPARENT
    }

    override fun getColor(resID: Int, alpha: Float): Int {
        val color = getColor(resID)

        return adjustAlpha(color, alpha)
    }

    override fun getColor(
        @ColorRes lowColorResID: Int, @ColorRes
        highColorResID: Int, proportion: Float
    ): Int {
        return ArgbEvaluator().evaluate(
            proportion,
            getColor(lowColorResID),
            getColor(highColorResID)
        ) as Int
    }

    private fun adjustAlpha(
        color: Int,
        alpha: Float
    ) = Color.argb(
        (Color.alpha(color) * alpha).roundToInt(),
        Color.red(color),
        Color.green(color),
        Color.blue(color)
    )

    //-------------------------------------------
    // endregion ColorProvider Overrides
    //-------------------------------------------

    //-------------------------------------------
    // region DrawableProvider Overrides
    //-------------------------------------------

    override fun getDrawable(@DrawableRes resID: Int?): Drawable? {
        return resID?.let { context.resources?.getDrawable(it, context.theme) }
    }

    //-------------------------------------------
    // endregion DrawableProvider Overrides
    //-------------------------------------------

    //-------------------------------------------
    // region IntegerProvider Overrides
    //-------------------------------------------

    override fun getInt(@IntegerRes resID: Int) = context.resources.getInteger(resID)

    //-------------------------------------------
    // endregion IntegerProvider Overrides
    //-------------------------------------------

    //----------------------------------------------------------------------------------------------
    // region DimenProvider Overrides
    //----------------------------------------------------------------------------------------------

    override fun getDimen(@DimenRes resID: Int) = context.resources.getDimension(resID)

    //----------------------------------------------------------------------------------------------
    // endregion DimenProvider Overrides
    //----------------------------------------------------------------------------------------------


    //-------------------------------------------
    // region LayoutManagerProvider Overrides
    //-------------------------------------------

    override fun getLinearLayoutManager(orientation: Int, reverseLayout: Boolean) = object :
        LinearLayoutManager(context, orientation, reverseLayout) {
        override fun supportsPredictiveItemAnimations(): Boolean {
            return true
        }
    }

    override fun getGridLayoutManager(numberColumns: Int): GridLayoutManager = object :
        GridLayoutManager(context, numberColumns) {
        override fun supportsPredictiveItemAnimations(): Boolean {
            return true
        }
    }

    //-------------------------------------------
    // endregion LayoutManagerProvider Overrides
    //-------------------------------------------

    //-------------------------------------------
    // region StringProvider Overrides
    //-------------------------------------------

    override fun getString(resID: Int): String = context.getString(resID)

    override fun getString(resId: Int, vararg formatArgs: Any): String = context.getString(
        resId,
        *formatArgs
    )

    override fun getHtmlString(resID: Int): Spanned = context.getHtmlSpannedString(resID)

    override fun getHtmlString(
        resId: Int,
        vararg formatArgs: Any
    ): Spanned = context.getHtmlSpannedString(
        resId,
        *formatArgs
    )

    override fun getPluralString(
        resID: Int,
        count: Int
    ): String = context.resources.getQuantityString(
        resID,
        count
    )

    override fun getPluralString(
        resID: Int,
        count: Int,
        vararg formatArgs: Any
    ): String = context.resources.getQuantityString(
        resID,
        count,
        formatArgs
    )

    //-------------------------------------------
    // endregion StringProvider Overrides
    //-------------------------------------------

}