class User {
  String? userName;
  String? email;
  String? password;
  String? role;

  User({this.userName, this.email, this.password, this.role});

  User.fromJson(Map<String, dynamic>? json) {
    // Use null-aware operators (??) to handle null values and provide defaults
    userName = json?['userName'] ?? ''; // Provide an empty string as a default
    email = json?['email'] ?? '';
    password = json?['password'] ?? '';
    role = json?['role'] ?? '';
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['userName'] = userName;
    data['email'] = email;
    data['password'] = password;
    data['role'] = role;
    return data;
  }
}
