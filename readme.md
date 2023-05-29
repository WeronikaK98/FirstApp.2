## Struktura klas oraz pseudokod
- Nowy projekt maven
- FirstApp w odpowiednim pakiecie
- Klasy - model - ParentProfile, ChildProfile, ArtisticLesson, SportActivity
    - Konstruktory
    - Relacje między nimi
- Pseudokod głównej logiki


## Główna pętla programu oraz komunikacja z użytkownikiem
- Główna pętla programu (zmienna sterująca i obsługa wyjątków)
- UserInputManager, UserInputCommand - szkic
- Implementacja UserInputManager
- Implementacja UserInputCommand
- Wyświetlenie UserInputCommand w głównej pętli


## Testy aplikacji i TDD
- Dodanie JUnit5 do projektu
- Wygenerowanie testu dla UserInputCommand


## Implementacja obsługi komend
- Pusta lista commandHandlerów
- Interfejs CommandHandler
- BaseCommandHandler
- HelpCommandHandler
- QuitCommandHandler
- Dodanie handlerów do listy i obsługa listy
    - optional
    - log nieznany command handler
    - break głównej pętli


## Komunikacja z systemem plików oraz utrwalenie danych
- CategoryCommandHandler - szablon
- Zapis do pliku, komunikacja z DAO, CategoryDao
- Wypełnienie CategoryCommandHandler
- Category.toString


## Serializacja obiektów
- Copy CategoryDao to QuestionDao -> problem z serializacją
    - Zależność jackson-databind
    - Refaktor QuestionDao z jackson


## Refaktoryzacja kodu
- Wprowadzenie enum Action
    - Refaktor po wprowadzeniu UserInputCommand.action
- QuestionCommandHandler
    - Dodanie CategoryDao i pobrani kategorii
    - Metoda CategoryDao.findOne
    - Refaktor CategoryDao na jackson
    - Model.Question - default konstruktor dla jackson


## Logi, obsługa wyjątków oraz walidacja danych
- Dodajemy loggery: do wszystkich klas
- AnswerCommandHandler kopia z question
    - questionDao.findOne
    - questionDao.findAnswer
- validacja parametrów
    - Spróbować wprowadzić niepoprawne dane
    - CategoryCommandHandler walidacja parametrów
    - Główna pętla dodatkowy catch na walidację


## Dalszy rozwój aplikacji
- Brak obsługi spacji
    - W jaki inny sposób oddzielić parametry?
- Przechowywanie danych
    - Rozważyć wprowadzenie bazy danych
- Dao
    - Wynieść wspólne części przed nawias
    - Framework do obsługi danych
- Zaimplementować dodatkowe akje
    - Usuwanie
    - Aktualizacja
- Dodać więcej wyrażeń lambda i strumieni
- Wprowadzenie warstwy webowej