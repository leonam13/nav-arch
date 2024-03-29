package com.raywenderlich.android.bookmanstreasure.destinations

import android.os.Bundle
import android.support.v4.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.raywenderlich.android.bookmanstreasure.ui.authordetails.AuthorDetailsDialog

/**
 * Created by Leo Almeida on 2019-07-19.
 */

@Navigator.Name("author")
class AuthorDetailsNavigator(private val manager: FragmentManager) : Navigator<AuthorDetailsNavigator.Destination>() {

    override fun navigate(destination: Destination, args: Bundle?, navOptions: NavOptions?, navigatorExtras: Extras?): NavDestination? {
        val dialog = AuthorDetailsDialog()
        dialog.arguments = args
        dialog.show(manager, AuthorDetailsDialog.TAG)
        return Destination(this)
    }

    override fun createDestination(): Destination = Destination(this)

    override fun popBackStack(): Boolean = false

    class Destination(authorDetailsNavigator: AuthorDetailsNavigator) : NavDestination(authorDetailsNavigator)
}