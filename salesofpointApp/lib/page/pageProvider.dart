import 'package:flutter/material.dart';

enum PageType {
  Dashboard,
  AddProduct,
  List,
}

class PageProvider with ChangeNotifier {
  PageType _currentPage = PageType.Dashboard;

  PageType get currentPage => _currentPage;

  void setPage(PageType newPage) {
    _currentPage = newPage;
    notifyListeners();
  }
}
