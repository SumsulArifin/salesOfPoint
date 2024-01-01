import 'package:flutter/material.dart';

class Sale extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sale'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Welcome to the Sale!',
              style: TextStyle(fontSize: 24.0),
            ),
            // Add other widgets and components as needed for your Sale
          ],
        ),
      ),
    );
  }
}
