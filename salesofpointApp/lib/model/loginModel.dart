class AuthenticationRequest {
  final String email;
  final String password;

  AuthenticationRequest({required this.email, required this.password});

  Map<String, dynamic> toJson() {
    return {
      'email': email,
      'password': password,
    };
  }
}

class AuthenticationResponse {
  final String accessToken;
  final String refreshToken;

  AuthenticationResponse({required this.accessToken, required this.refreshToken});

  factory AuthenticationResponse.fromJson(Map<String, dynamic> json) {
    return AuthenticationResponse(
      accessToken: json['accessToken'],
      refreshToken: json['refreshToken'],
    );
  }
}
