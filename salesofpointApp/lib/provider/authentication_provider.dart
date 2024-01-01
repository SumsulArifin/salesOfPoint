import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../model/loginModel.dart';
import '../service/authservice.dart';


class AuthenticationProvider extends ChangeNotifier {
  final AuthenticationService _authenticationService = AuthenticationService();

  AuthenticationResponse? _authResponse;

  AuthenticationResponse? get authResponse => _authResponse;

  Future<void> authenticateUser(BuildContext context, AuthenticationRequest request) async {
    try {
      final response = await _authenticationService.authenticate(request);
      _authResponse = response;
      notifyListeners();

      // Storing tokens securely using shared_preferences
      final prefs = await SharedPreferences.getInstance();
      await prefs.setString('accessToken', response.accessToken);
      await prefs.setString('refreshToken', response.refreshToken);

      Navigator.of(context).pushReplacementNamed('/home');
    } catch (e) {
      print('Authentication failed: $e');
      // Handle authentication failure (show error message, etc.)
    }
  }

  Future<void> logout(BuildContext context) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove('accessToken');
    await prefs.remove('refreshToken');

    _authResponse = null;
    notifyListeners();

    Navigator.of(context).pushReplacementNamed('/login');
  }
}
