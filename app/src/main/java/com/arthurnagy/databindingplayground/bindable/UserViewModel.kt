/*
 * Copyright (c) 2018 Halcyon Mobile
 * http://www.halcyonmobile.com
 * All rights reserved.
 */

package com.arthurnagy.databindingplayground.bindable

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.arthurnagy.databindingplayground.BR
import com.arthurnagy.databindingplayground.R
import com.arthurnagy.databindingplayground.StringProvider

class UserViewModel(
    private val stringProvider: StringProvider
) : BaseObservable() {

    @get:Bindable
    var firstName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }

//    @get:Bindable
//    var firstName: String by bindable("", BR.firstName)

//    @get:Bindable
//    var lastName: String by bindable("", BR.lastName)

    val displayName: String
        @Bindable(value = ["firstName", "lastName"])
        get() = stringProvider.getString(R.string.display_name, firstName, lastName)

}