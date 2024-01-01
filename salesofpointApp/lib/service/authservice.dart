import 'dart:convert';
import 'package:http/http.dart' as http;
import '../model/loginModel.dart';

class AuthenticationService {
  static const String baseUrl = 'http://192.168.10.135:8080/api/v1/auth';

  Future<AuthenticationResponse> authenticate(AuthenticationRequest request) async {
    final response = await http.post(
      Uri.parse('$baseUrl/authenticate'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(request.toJson()),
    );

    if (response.statusCode == 200) {
      return AuthenticationResponse.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to authenticate');
    }
  }
}
