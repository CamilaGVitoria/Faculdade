import 'dart:io';

void main(){
  print('Digite a palavra para calcular a pontuação Scabble: ');
  String palavra = stdin.readLineSync()!;

  int resultado = calculoDaPontuacao(palavra);

  print('A pontuação Scabble da palavra digitada é $resultado.');

}

int calculoDaPontuacao(String palavra){
  Map<String, int> valores = {
    'A' : 1, 'E' : 1, 'I' : 1, 'O' : 1, 'U' : 1, 'L' : 1, 'N' : 1, 'R' : 1, 'S' : 1, 'T' : 1,
    'D' : 2, 'G' : 2,
    'B' : 3, 'C' : 3, 'M' : 3, 'P' : 3,
    'F' : 4, 'H' : 4, 'V' : 4, 'W' : 4, 'Y' : 4,
    'K' : 5,
    'J' : 8, 'X' : 8,
    'Q' : 1, 'Z' : 1,
    };

    int pontuacao = 0;

    for(int i = 0; i < palavra.length; i++) {
      String letra = palavra[i].toUpperCase();
      if (valores.containsKey(letra)) {
        pontuacao += valores[letra]!;
      }
    }
    return pontuacao;
}