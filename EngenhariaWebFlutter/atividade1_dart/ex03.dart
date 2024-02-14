import 'dart:io';

void main(){
  print('Digite um número para que seja verificado se é válido ou não segundo a fórmula de Luhn:');
  String numeroString = stdin.readLineSync()!.replaceAll(' ', '');

  if (numeroString.length > 1) {
    int somaNumeros = 0;

    for (var i = numeroString.length - 1; i >= 0; i --) {
      int numero = int.parse(numeroString[i]);
      
      if((numeroString.length - i) % 2 == 0 ){
        numero *= 2;
        if (numero> 9) {
          numero -= 9;
        }
      }

      somaNumeros += numero;

    }

  if (somaNumeros % 10 == 0) {
    print('O número digitado é válido de acordo com a fórmula de Luhn!');
  }else{
    print('Número inválido!');
  }

  }else{
    print('Número inválido!');
  }


}