import 'package:app_chatgpt/src/page/home_page/home_page.dart';
import 'package:app_chatgpt/src/service/image_generate_service.dart';
import 'package:app_chatgpt/src/service/text_generate_service.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class MainApp extends StatelessWidget {
  const MainApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(
          create: (_) => TextGenerateService(),
        ),
        ChangeNotifierProvider(
          create: (_) => ImageGenerateService(),
        ),
      ],
      child: MaterialApp(
        title: 'Chat GPT',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          primarySwatch: Colors.blueGrey,
        ),
        home: const HomePage(),
      ),
    );
  }
}
