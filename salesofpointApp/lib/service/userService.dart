import 'dart:convert';
import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;

class AuthService {
  Future<Map<String, dynamic>> fetchData() async {
    final response = await http.get(Uri.parse('http://lfs.zilodev.com/api/product'));

    if (response.statusCode == 200) {
      return json.decode(response.body);
    } else {
      throw Exception('Failed to load data');
    }
  }

}
