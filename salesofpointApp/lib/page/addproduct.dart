import 'package:flutter/material.dart';

class AddProduct extends StatelessWidget {


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Add Product'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Welcome to the Product!',
              style: TextStyle(fontSize: 24.0),
            ),
            // Add other widgets and components as needed for your Purchase
          ],
        ),
      ),
    );
  }
}
