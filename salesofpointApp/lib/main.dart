
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:salesofpointapp/page/productList.dart';
import 'package:salesofpointapp/provider/authentication_provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider<AuthenticationProvider>(
          create: (_) => AuthenticationProvider(),
        ),
        // Other providers if needed
      ],
      child: MaterialApp(
        title: 'Your App',
        home: ProductList(),
        // Other configurations
      ),
    );
  }
}



// import 'package:flutter/material.dart';
// import 'package:provider/provider.dart';
// import 'package:salesofpointapp/page/MainScreen.dart';
// import 'package:salesofpointapp/page/pageProvider.dart';
//
//
// void main() {
//   runApp(MyApp());
// }
//
// class MyApp extends StatelessWidget {
//   @override
//   Widget build(BuildContext context) {
//     return ChangeNotifierProvider(
//       create: (context) => PageProvider(), // Assuming PageProvider is your provider
//       child: MaterialApp(
//         debugShowCheckedModeBanner: false,
//         title: 'Your App Title',
//         home: MainScreen(),
//       ),
//     );
//   }
// }
