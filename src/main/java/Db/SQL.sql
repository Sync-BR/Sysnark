
/**
 * Author:  SYNC
 * Created: 27 de abr. de 2024
 */
/*Criar banco de dados*/
CREATE SCHEMA `market`;

/* Criar tabela de produtos */
CREATE TABLE `market`.`products` (
  `idproducts` INT NOT NULL AUTO_INCREMENT,
  `nameProduct` VARCHAR(100) NOT NULL,
  `descriptionProduct` VARCHAR(247) NOT NULL,
  `priceProduct` VARCHAR(20) NOT NULL,
  `barcodeProduct` VARCHAR(15) NOT NULL,
  `brandProduct` VARCHAR(20) NOT NULL,
  `amountproduct` INT NOT NULL,
  PRIMARY KEY (`idproducts`),
  UNIQUE (`barcodeProduct`)
);


/*Gerar dados para teste*/
INSERT INTO `market`.`products` (`nameProduct`, `descriptionProduct`, `priceProduct`, `barcodeProduct`, `brandProduct`, `amountproduct`) VALUES
('Leite Integral', 'Leite de vaca integral, 1L', ' 4,50', '7891000053508', 'Nestlé', 150),
('Café em Pó', 'Café moído forte 500g', ' 9,90', '7896202400131', 'Pilão', 200),
('Arroz Branco', 'Arroz branco tipo 1, 5kg', ' 19,90', '7893500037557', 'Tio João', 300),
('Feijão Preto', 'Feijão preto, 1kg', ' 6,89', '7891910000197', 'Kicaldo', 120),
('Macarrão Espaguete', 'Espaguete de semola 500g', ' 3,50', '7891000105507', 'Barilla', 150),
('Óleo de Soja', 'Óleo de soja refinado 900ml', ' 7,99', '7896040700500', 'Liza', 180),
('Açúcar Refinado', 'Açúcar branco refinado 1kg', ' 3,79', '7891910001071', 'União', 200),
('Sal Refinado', 'Sal refinado 1kg', ' 1,99', '7898905758045', 'Cisne', 250),
('Molho de Tomate', 'Molho de tomate tradicional 340g', ' 2,49', '7891095100011', 'Pomarola', 100),
('Farinha de Trigo', 'Farinha de trigo especial 1kg', ' 4,29', '7894000011515', 'Dona Benta', 150),
('Chocolate em Barra', 'Chocolate ao leite 90g', ' 5,99', '7622300726697', 'Milka', 200),
('Biscoito Recheado', 'Biscoito de chocolate recheado 130g', ' 2,50', '7891000052907', 'Nestlé', 300),
('Detergente Líquido', 'Detergente líquido neutro 500ml', ' 1,79', '7891024128901', 'Ypê', 250),
('Desinfetante', 'Desinfetante eucalipto 1L', ' 4,99', '7891025107353', 'Pinho Sol', 180),
('Papel Higiênico', 'Papel higiênico folha dupla 4 rolos', ' 6,90', '7896224483657', 'Neve', 220),
('Shampoo', 'Shampoo hidratante 350ml', ' 14,90', '7899026489453', 'Pantene', 130),
('Condicionador', 'Condicionador restauração 350ml', ' 15,90', '7899026498417', 'Pantene', 130),
('Sabonete Barra', 'Sabonete de glicerina 90g', ' 2,20', '7896094916136', 'Dove', 150),
('Cerveja Pilsen', 'Cerveja Pilsen 350ml', ' 2,99', '7891991010856', 'Heineken', 250),
('Suco de Laranja', 'Suco de laranja natural 1L', ' 8,50', '7892840222949', 'Natural One', 100);

/*Construir tabela para funcionarios*/
CREATE TABLE `market`.`employees` (
  `idEmployees` INT NOT NULL AUTO_INCREMENT,
  `Employeename` VARCHAR(80) NOT NULL,
  `Dateofbirth` DATE NOT NULL,  
  `Cpf` VARCHAR(15) NOT NULL,
  `Cep` VARCHAR(15) NOT NULL,
  `State` VARCHAR(50) NOT NULL,
  `Road` VARCHAR(50) NOT NULL,
  `Neighborhood` VARCHAR(50) NOT NULL,
  `City` VARCHAR(50) NOT NULL,
  `Housenumber` INT NOT NULL,
  `Complement` VARCHAR(50) NULL,
  `Cellphone` VARCHAR(14) NOT NULL, 
  `Bank` VARCHAR(50) NOT NULL,
  `Bankaccount` VARCHAR(12) NOT NULL,
  `Login` VARCHAR(20) UNIQUE NOT NULL, 
  `Password` VARCHAR(12) NOT NULL,
  `Access` INT NOT NULL,

  PRIMARY KEY (`idEmployees`)); 

/*Código para adicionar os funcionarios para teste*/
INSERT INTO `market`.`employees` 
(Employeename, Dateofbirth, Cpf, Cep, State, Road, Neighborhood, City, Housenumber, Complement, Cellphone, Bank, Bankaccount, Login, Password, Access) 
VALUES 
('João da Silva', '1990-04-15', '123.456.789-09', '01427-000', 'São Paulo', 'Rua das Flores', 'Jardim Paulista', 'São Paulo', 145, 'Apto 201', '(11) 98765-4321', 'Banco do Brasil', '123456-7', 'joaosilva', 'senha123', 3),
('Maria Oliveira', '1985-08-23', '987.654.321-00', '22021-001', 'Rio de Janeiro', 'Avenida Atlântica', 'Copacabana', 'Rio de Janeiro', 204, 'Bloco B', '(21) 97654-3210', 'Caixa Econômica Federal', '765432-1', 'mariaoliv', '123senha', 2),
('Carlos Alberto', '1978-02-11', '456.123.789-12', '30140-101', 'Minas Gerais', 'Praça da Liberdade', 'Savassi', 'Belo Horizonte', 980, NULL, '(31) 96543-2109', 'Itaú Unibanco', '456789-3', 'carlosalb', 'senha456', 2),
('Ana Carolina', '1992-12-05', '789.456.123-45', '40026-010', 'Bahia', 'Rua das Laranjeiras', 'Pelourinho', 'Salvador', 57, NULL, '(71) 95432-1098', 'Bradesco', '789123-4', 'anacarol', 'abc123', 1),
('Lucas Martins', '1987-05-25', '321.789.456-78', '80020-320', 'Paraná', 'Rua XV de Novembro', 'Centro', 'Curitiba', 600, 'Sala 5', '(41) 94321-0987', 'Santander Brasil', '321654-8', 'lucasmart', 'senha789', 1),
('Patrícia Souza', '1991-07-19', '234.567.891-23', '51011-000', 'Pernambuco', 'Avenida Boa Viagem', 'Boa Viagem', 'Recife', 230, 'Apto 1201', '(81) 93210-9876', 'Banco Safra', '234567-9', 'patricias', 'minhasenha', 1),
('Eduardo Lima', '1983-03-30', '567.891.234-56', '90020-120', 'Rio Grande do Sul', 'Avenida Borges de Medeiros', 'Centro', 'Porto Alegre', 789, NULL, '(51) 92109-8765', 'Banco Inter', '567891-2', 'eduardol', 'senha12345', 1),
('Fernanda Castro', '1994-01-22', '891.234.567-89', '88015-200', 'Santa Catarina', 'Rua Beira Mar', 'Centro', 'Florianópolis', 112, NULL, '(48) 91098-7654', 'Nubank', '891234-5', 'fernandac', '1234senha', 1),
('Roberto Nunes', '1980-09-10', '678.912.345-67', '29055-131', 'Espírito Santo', 'Avenida Vitória', 'Praia do Canto', 'Vitória', 456, 'Casa', '(27) 89987-6543', 'Banco do Brasil', '678912-3', 'roberton', 'senha5678', 1),
('Amanda Gomes', '1995-06-01', '345.678.912-34', '22070-010', 'Rio de Janeiro', 'Avenida Nossa Senhora de Copacabana', 'Copacabana', 'Rio de Janeiro', 321, 'Apto 302', '(21) 88876-5432', 'Caixa Econômica Federal', '345678-1', 'amandag', 'senha890', 1),
('Thiago Ribeiro', '1988-11-15', '912.345.678-90', '01310-000', 'São Paulo', 'Avenida Paulista', 'Bela Vista', 'São Paulo', 134, 'Torre 2', '(11) 87765-4321', 'Itaú Unibanco', '912345-6', 'thiagor', '12345678', 1),
('Juliana Moraes', '1993-03-09', '678.345.912-12', '30130-000', 'Minas Gerais', 'Avenida Afonso Pena', 'Funcionários', 'Belo Horizonte', 567, 'Bloco 3', '(31) 86654-3210', 'Bradesco', '678345-7', 'julianam', 'senha2345', 1),
('Ricardo Alves', '1985-07-30', '123.789.456-00', '60060-170', 'Ceará', 'Rua Dragão do Mar', 'Praia de Iracema', 'Fortaleza', 234, NULL, '(85) 85543-2109', 'Santander Brasil', '123789-0', 'ricardoa', 'senha3456', 1),
('Simone Freitas', '1975-10-17', '789.123.456-78', '69050-055', 'Amazonas', 'Avenida das Torres', 'Parque 10', 'Manaus', 890, 'Apto 701', '(92) 84432-1098', 'Banco Safra', '789123-1', 'simonef', 'senha4567', 1),
('Tiago Mendes', '1992-01-31', '456.789.123-45', '74003-010', 'Goiás', 'Avenida Goiás', 'Setor Central', 'Goiânia', 321, 'Sala 202', '(62) 83321-0987', 'Banco Inter', '456789-0', 'tiagom', 'senha7890', 1);
