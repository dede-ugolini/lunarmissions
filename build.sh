#!/bin/bash

# Script para executar o projeto Java com classpath correto
# Este script garante que todas as dependências sejam carregadas

echo "Compilando o projeto..."
mvn package -q 2>/dev/null
if [ $? -ne 0 ]; then
  echo ""
  echo "Erro na compilação. Verifique os erros acima."
  exit 1
fi

echo "Executando nosso projeto..."
java -jar target/lunarmissions-1.0-SNAPSHOT.jar
