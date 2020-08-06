# java-hibernate

Первые попытки освоить Hibernate

@GeneratedValue(strategy = GenerationType.IDENTITY) - генерирует ключ через БД
                           GenerationType.SEQUENCE - лезет в таблицу hibernate_sequence за ключом
                           GenerationType.TABLE - лезет в таблицу hibernate_sequence<b>s</b> за ключом