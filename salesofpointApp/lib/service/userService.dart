import 'dart:convert';
import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;

class AuthService extends ChangeNotifier{
  Future<Map<String, String>> registerUser(
      String email, String userName, String password, String role) async {
    final url = Uri.parse('http://192.168.10.135:8080/api/v1/auth/register');
    final response = await http.post(
      url,
      body: json.encode({
        'email': email,
        'userName': userName,
        'password': password,
        'role': role,
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    );

    if (response.statusCode == 200) {
      final responseData = json.decode(response.body);
      return {
        'accessToken': responseData['accessToken'],
        'refreshToken': responseData['refreshToken'],
      };
    } else {
      throw Exception('Failed to register user');
    }
  }
}
