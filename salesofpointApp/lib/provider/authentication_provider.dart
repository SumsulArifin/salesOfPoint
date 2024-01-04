import 'package:flutter/material.dart';
import '../model/product.model.dart';
import '../service/authService.dart';
import '../service/userService.dart';


class AuthenticationProvider with ChangeNotifier {

  final AuthService _authService = AuthService();
  List<Product> _products = [];

  List<Product> get products => _products;
  

  Future<void> fetchData() async {
    try {
      final Map<String, dynamic> data = await _authService.fetchData();
      List<dynamic> productList = data['products'];
      _products = productList.map((e) => Product.fromJson(e)).toList();
      notifyListeners();
    } catch (e) {
      print(e);
      throw Exception('Failed to fetch data');
    }
  }
}
