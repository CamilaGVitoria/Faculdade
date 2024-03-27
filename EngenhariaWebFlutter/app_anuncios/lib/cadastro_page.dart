import 'package:app_anuncios/model/produto.dart';
import 'package:flutter/material.dart';

class CadastroPage extends StatefulWidget {
  const CadastroPage({Key? key}) : super(key: key);

  @override
  State<CadastroPage> createState() => _CadastroPage();
}

class _CadastroPage extends State<CadastroPage> {
  final TextEditingController _nomeControler = TextEditingController();
  final TextEditingController _informacoesControler = TextEditingController();
  final TextEditingController _precoControler = TextEditingController();
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        iconTheme: const IconThemeData(color: Colors.white),
        title: const Text(
          'Cadastro',
          style: TextStyle(color: Colors.white),
        ),
        centerTitle: true,
        backgroundColor: Colors.deepOrange,
      ),
      body: Form(
        key: _formKey,
        child: Column(
          children: [
            Container(
              padding: const EdgeInsets.only(top: 20, right: 20, left: 20),
              child: TextFormField(
                controller: _nomeControler,
                validator: (value) {
                  if (value!.isEmpty) return 'Preenchimento obrigatório';
                },
                decoration: const InputDecoration(
                  label: Text('Digite o nome do anúncio'),
                  border: OutlineInputBorder(),
                ),
              ),
            ),
            Container(
              padding: const EdgeInsets.only(top: 20, right: 20, left: 20),
              child: TextFormField(
                controller: _informacoesControler,
                validator: (value) {
                  if (value!.isEmpty) return 'Preenchimento obrigatório';
                },
                decoration: const InputDecoration(
                  label: Text('Digite as informações do anúncio'),
                  border: OutlineInputBorder(),
                ),
              ),
            ),
            Container(
              padding: const EdgeInsets.only(top: 20, right: 20, left: 20),
              child: TextFormField(
                controller: _precoControler,
                validator: (value) {
                  if (value!.isEmpty) return 'Preenchimento obrigatório';
                },
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(
                  label: Text('Digite o preço do anunciado'),
                  prefixText: 'R\$',
                  border: OutlineInputBorder(),
                ),
              ),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  height: 80,
                  width: 200,
                  padding:
                      const EdgeInsets.symmetric(vertical: 20, horizontal: 10),
                  child: ElevatedButton(
                    style:
                        ElevatedButton.styleFrom(backgroundColor: Colors.green),
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        Produto produto = Produto(
                          _nomeControler.text,
                          _informacoesControler.text,
                          _precoControler.text,
                        );
                        Navigator.pop(context, produto);
                      }
                    },
                    child: const Text(
                      'Salvar',
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
                Container(
                  height: 80,
                  width: 200,
                  padding:
                      const EdgeInsets.symmetric(vertical: 20, horizontal: 10),
                  child: ElevatedButton(
                    onPressed: () {
                      Navigator.pop(context);
                    },
                    style:
                        ElevatedButton.styleFrom(backgroundColor: Colors.red),
                    child: const Text(
                      'Cancelar',
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
