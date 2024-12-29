package com.soumya.farmconnect.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ForgotPasswordViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _message = MutableStateFlow("")
    val message = _message.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun sendResetLink() {
        if (_email.value.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(_email.value).matches()) {
            viewModelScope.launch {
                _isLoading.value = true
                delay(1500) // Simulating network delay
                _message.value = "Password reset link sent to ${_email.value}"
                _isLoading.value = false
            }
        } else {
            _message.value = "Please enter a valid email address."
        }
    }

    fun resetMessage() {
        _message.value = ""
    }
}
