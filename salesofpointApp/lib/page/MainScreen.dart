import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:salesofpointapp/page/pageProvider.dart';

import 'Dashboard.dart';
import 'Purchase.dart';
import 'Sale.dart';
import 'SaleList.dart';

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
            case PageType.Purchase:
              return Purchase();
            case PageType.Sale:
              return Sale();
            case PageType.SaleList:
              return SaleList();
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
              icon: Icon(Icons.dashboard,color: Colors.black,),
              label: 'Dashboard',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.shopping_cart,color: Colors.black),
              label: 'Purchase',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.attach_money,color: Colors.black),
              label: 'Sale',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.list,color: Colors.black),
              label: 'Sale List',
            ),
          ],
        ),
      ),
    );
  }
}