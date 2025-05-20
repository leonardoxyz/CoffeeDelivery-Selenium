# ☕ Coffee Delivery - Automação de Testes

## 📋 Sobre o Projeto
Este projeto contém a automação de testes para a aplicação Coffee Delivery, um sistema de delivery de cafés desenvolvido por [Ramon Trovão](https://github.com/ramontrovao). O framework foi desenvolvido utilizando as melhores práticas de automação de testes e padrões de projeto.

## 🚀 Tecnologias Utilizadas
- Java
- Selenium WebDriver 4.10.0
- JUnit 5
- WebDriverManager 5.8.0
- AShot (para capturas de tela)
- SLF4J (para logging)

## ✨ Funcionalidades Testadas
- Validação do logo do sistema
- Navegação e validação do carrinho de compras
- Validação do texto do footer ("Feito com ♥ por Ramon Pinheiro")
- Gerenciamento de quantidade de produtos
- Validação de elementos visuais através de screenshots

## 🛠️ Configuração do Ambiente
1. Clone o repositório
```bash
git clone https://github.com/leonardoxyz/coffee-delivery.git
```

2. Certifique-se de ter o Java JDK 11+ instalado

3. Instale as dependências do Maven
```bash
mvn clean install
```

## 🧪 Executando os Testes
Para executar todos os testes:
```bash
mvn test
```

## 📝 Padrões de Código
- Page Objects para encapsulamento dos elementos da página
- Validações separadas em classes específicas
- Uso de esperas explícitas para melhor estabilidade
- Logging para melhor rastreabilidade
- Screenshots para validação visual

## 📄 Licença
Este projeto está sob a licença MIT.

## 👨‍💻 Autores
- [Ramon Trovão](https://github.com/ramontrovao) - Criador do projeto Coffee Delivery
- [Leonardo Santos](https://github.com/leonardoxyz) - Desenvolvedor da automação de testes

---
⭐️ From [Leonardo Santos](https://github.com/leonardoxyz)