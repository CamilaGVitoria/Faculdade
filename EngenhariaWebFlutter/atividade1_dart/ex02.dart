import 'dart:io';

void main(){
  print('Digite as cores dos registores separadas por um -: ');
  String cores = stdin.readLineSync()!;
  
  String valorResistencia = calculoValorResistencia(cores);

  print('O valor da resistencia do resistor é $valorResistencia.');
}

String calculoValorResistencia(String cores){
  Map<String, int> valoresCores = {
    'PRETO' : 0, 'MARROM' : 1, 'VERMELHO' : 2, 'LARANJA' : 3, 'AMARELO' : 4,
    'VERDE' : 5, 'AZUL' : 6, 'VIOLETA' : 7, 'CINZA' : 8, 'BRANCO' : 9,
  };

  String valor = '';

  List<String> listaCores = cores.split('-');

  for (int i = 0; i < listaCores.length; i++) {
    String cor = listaCores[i].toUpperCase();
    if(valoresCores.containsKey(cor)){
      valor += valoresCores[cor]!.toString();
    }
  }

  valor = valor.substring(0, 2);

  return valor;
}