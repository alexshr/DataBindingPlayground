/*
 * Copyright (c) 2018 Halcyon Mobile
 * http://www.halcyonmobile.com
 * All rights reserved.
 */

package com.arthurnagy.databindingplayground

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class UserViewModel : ViewModel() {

    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()
    val displayName = ObservableField<String>().dependsOn(firstName, lastName) { firstName, lastName ->
        resourceProvider?.getString(R.string.display_name, firstName ?: "", lastName ?: "") ?: ""
    }
    var resourceProvider: ResourceProvider? = null

    init {
        firstName.observe {
            println("UserViewModel.onPropertyChanged: firstName: $it")
        }
        lastName.observe {
            println("UserViewModel.onPropertyChanged: lastName: $it")

        }
        displayName.observe {
            println("UserViewModel.onPropertyChanged: displayName: $it")
        }

    }

}