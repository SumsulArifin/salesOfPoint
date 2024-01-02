//
// import 'package:flutter/cupertino.dart';
// import 'package:flutter/material.dart';
// import 'package:provider/provider.dart';
// import 'package:salesofpointapp/page/Dashboard.dart';
// import 'package:salesofpointapp/page/MainScreen.dart';
// import 'package:salesofpointapp/page/Purchase.dart';
// import 'package:salesofpointapp/page/Sale.dart';
// import 'package:salesofpointapp/page/SaleList.dart';
// import 'package:salesofpointapp/page/pageProvider.dart';
//
// void main() {
//   runApp(
//     ChangeNotifierProvider(
//       create: (context) => PageProvider(),
//       child: MaterialApp(
//         debugShowCheckedModeBanner: false, // This should hide the debug banner
//         home: MainScreen(),
//       ),
//     ),
//   );
// }
//
//
//



import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:salesofpointapp/page/MainScreen.dart';
import 'package:salesofpointapp/page/login.dart';
import 'package:salesofpointapp/page/registration.dart';
import 'package:salesofpointapp/provider/authentication_provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => AuthenticationProvider(),
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Authentication Example',
        initialRoute: '/',
        routes: {
          '/':(context)=>Login(),
          '/MainScreen': (context) => MainScreen(),
          '/RegistrationPage': (context) => RegistrationPage(),
          '/login': (context) => Login(), // Add a route for the login page
        },
      ),
    );
  }
}
