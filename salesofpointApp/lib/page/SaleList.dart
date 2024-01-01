import 'package:flutter/material.dart';

class SaleList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('SaleList'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Welcome to the SaleList!',
              style: TextStyle(fontSize: 24.0),
            ),
            // Add other widgets and components as needed for your SaleList
          ],
        ),
      ),
    );
  }
}
