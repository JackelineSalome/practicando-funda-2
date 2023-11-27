Feature: Guardar una nueva cita

  Scenario: El usuario guarda una nueva cita
    Given el servicio de citas está disponible
    When el usuario envía una nueva cita
    Then se crea una nueva cita en la base de datos
    And la respuesta contiene los detalles de la nueva cita
    And la respuesta tiene el código de estado 201
