Feature: Flujos de compra en SauceDemo

  Scenario: Agregar producto al carrito
    Given el usuario navega a la página de login
    When inicia sesión con credenciales válidas
    And agrega un producto al carrito
    And va al carrito de compras
    Then el producto debería verse en el carrito

  Scenario: Flujo de compra completo
    Given el usuario navega a la página de login
    When inicia sesión con credenciales válidas
    And agrega un producto al carrito
    And va al carrito de compras
    And completa la compra
    Then debería ver el mensaje de confirmación

  Scenario: Flujo de compra completo con eliminación
    Given el usuario navega a la página de login
    When inicia sesión con credenciales válidas
    And agrega un producto al carrito
    And va al carrito de compras
    And elimina el producto del carrito
    And vuelve a la página de productos
    And agrega un producto al carrito
    And va al carrito de compras
    And completa la compra
    Then debería ver el mensaje de confirmación