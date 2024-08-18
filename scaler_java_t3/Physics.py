import matplotlib.pyplot as plt
import numpy as np

mass = 10
drag_coeff = 0.25
initial_velocity = 25
initial_angle = np.pi / 3

def euler_method(mass, initial_velocity, initial_angle, drag_coeff=0, initial_height=0, gravity=9.8, time_step=0.01):
    velocity_x = initial_velocity * np.cos(initial_angle)
    velocity_y = initial_velocity * np.sin(initial_angle)
    pos_x = 0
    pos_y = initial_height
    time = 0

    x_positions = []
    y_positions = []

    is_first_iteration = False
    while not is_first_iteration or pos_y > 0:
        is_first_iteration = True
        x_positions.append(pos_x)
        y_positions.append(pos_y)
        speed = np.sqrt(velocity_x**2 + velocity_y**2)
        acceleration_x = - (drag_coeff * speed * velocity_x) / mass
        acceleration_y = - gravity - (drag_coeff * speed * velocity_y) / mass
        
        velocity_x += acceleration_x * time_step
        velocity_y += acceleration_y * time_step
        
        pos_x += velocity_x * time_step + 0.5 * acceleration_x * (time_step**2)
        pos_y += velocity_y * time_step + 0.5 * acceleration_y * (time_step**2)
        
        time += time_step
    
    return x_positions, y_positions

x_drag, y_drag = euler_method(mass, initial_velocity, initial_angle, drag_coeff=drag_coeff)
x_no_drag, y_no_drag = euler_method(mass, initial_velocity, initial_angle)

plt.figure(figsize=(9, 5))
plt.title('Comparison of Projectile with and without air resistance')
plt.plot(x_no_drag, y_no_drag, label='without air resistance')
plt.plot(x_drag, y_drag, color='red', label='with air resistance')
plt.xlabel('Distance (x-axis) in m')
plt.ylabel('Height (y-axis) in m')
plt.legend()
plt.show()