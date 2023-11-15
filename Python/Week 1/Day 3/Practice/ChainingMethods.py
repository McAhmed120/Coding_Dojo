
class User:
    def __init__(self, username, email, points=0):
        self.username = username
        self.email = email
        self.points = points

    def display_info(self):
        print(f"Username: {self.username}")
        print(f"Email: {self.email}")
        print(f"Points: {self.points}")
        return self

    def enroll(self):
        print(f"{self.username} has been enrolled.")
        return self

    def spend_points(self, amount):
        self.points -= amount
        print(f"{self.username} spent {amount} points.")
        return self

# Creating user 1 and user 2 datas 
user1 = User(username="ahmed_ksibi", email="ahmedksibi67@gmail.com", points=100)
user2 = User(username="jane_doe", email="jane@gmail.com", points=150)

# Method chaining example
user1.display_info().enroll().spend_points(50)
user2.enroll().spend_points(80).display_info()
