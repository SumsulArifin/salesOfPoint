import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:salesofpointapp/page/addproduct.dart';
import 'package:salesofpointapp/page/pageProvider.dart';


import 'Dashboard.dart';
import 'Purchase.dart';
import 'Sale.dart';
import 'productList.dart';

class MainScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Center(child: Text('Point Of Sale'))),
      body: Consumer<PageProvider>(
        builder: (context, pageProvider, _) {
          switch (pageProvider.currentPage) {
            case PageType.Dashboard:
              return Dashboard();
            case PageType.AddProduct:
              return AddProduct();
            case PageType.List:
              return ProductList();
            default:
              return Container(); // Handle default or error case
          }
        },
      ),
      bottomNavigationBar: Consumer<PageProvider>(
        builder: (context, pageProvider, _) => BottomNavigationBar(
          currentIndex: pageProvider.currentPage.index,
          onTap: (index) {
            final newPage = PageType.values[index];
            pageProvider.setPage(newPage);
          },
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.dashboard, color: Colors.black),
              label: 'Dashboard',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.add, color: Colors.black),
              label: 'AddProduct',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.list, color: Colors.black),
              label: 'Product List',
            ),


          ],
        ),
      ),
    );
  }
}
