Feature: Obtener todas las citas

  Scenario: El usuario solicita todas las citas
    Given el servicio de citas está disponible
    When el usuario hace una solicitud para obtener todas las citas
    Then se devuelven todas las citas existentes
    And la respuesta tiene el código de estado 200
