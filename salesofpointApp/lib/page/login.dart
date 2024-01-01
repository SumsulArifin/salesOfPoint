import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../model/loginModel.dart';
import '../provider/authentication_provider.dart';
class Login extends StatelessWidget {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    final authProvider = Provider.of<AuthenticationProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: Text('Login'),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextFormField(
              controller: emailController,
              keyboardType: TextInputType.emailAddress,
              decoration: InputDecoration(
                labelText: 'Email',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 12.0),
            TextFormField(
              controller: passwordController,
              obscureText: true,
              decoration: InputDecoration(
                labelText: 'Password',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 24.0),
            ElevatedButton(
              onPressed: () {
                final email = emailController.text;
                final password = passwordController.text;
                if (email != null && email.isNotEmpty && password != null && password.isNotEmpty) {
                  final request = AuthenticationRequest(email: email, password: password);
                  authProvider.authenticateUser(context, request);
                } else {
                  // Handle empty or null fields (show error message, etc.)
                }
              },
              child: Text('Login'),
            ),

          ],
        ),
      ),
    );
  }
}
