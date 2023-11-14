class User:
    def __init__(self, name, email,BankAccount):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)

    def make_deposit(self, amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.account.balance}")
        return self

    def transfer_money(self, other_user, amount):
        self.account.withdraw(amount)
        other_user.account.deposit(amount)
        return self

# Example usage:
user1 = User("John Doe", "john.doe@email.com")
user2 = User("Jane Doe", "jane.doe@email.com")

user1.make_deposit(100).make_deposit(50).make_withdrawal(30).display_user_balance()

user2.make_deposit(200).make_deposit(300).make_withdrawal(100).display_user_balance()

user1.transfer_money(user2, 50).display_user_balance()
user2.display_user_balance()
