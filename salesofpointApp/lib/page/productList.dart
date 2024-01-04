import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../model/product.model.dart';
import '../provider/authentication_provider.dart';


class ProductList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final authenticationProvider = Provider.of<AuthenticationProvider>(context);
    List<Product> products = authenticationProvider.products;

    return Scaffold(
      appBar: AppBar(
        title: Text('Product List'),
      ),
      body: Center(
        child: products.isEmpty
            ? CircularProgressIndicator() // Show loading indicator if data is being fetched
            : ListView.builder(
          itemCount: products.length,
          itemBuilder: (context, index) {
            return ListTile(
              title: Text(products[index].productName),
              subtitle: Text(products[index].productPrice),
              leading: Image.network(products[index].productThumbnail),
              // Add more fields to display as needed
            );
          },
        ),
      ),
    );
  }
}
