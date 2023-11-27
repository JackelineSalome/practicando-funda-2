Feature: Filtrar Citas Disponibles

Scenario: El usuario filtra citas disponibles según sus preferencias
Given el servicio de citas está disponible
And el usuario ha iniciado sesión en su cuenta
When el usuario busca citas disponibles
And aplica filtros como ubicación, horario, intereses, etc.
Then el sistema muestra solo las citas que cumplen con los criterios de filtrado
And la respuesta tiene el código de estado 200