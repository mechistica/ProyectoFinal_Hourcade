Feature: Login en SauceDemo

  Scenario: Login exitoso
    Given el usuario navega a la página de login
    When inicia sesión con credenciales válidas
    Then debería visualizarse que la sesión está iniciada