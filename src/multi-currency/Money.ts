export default class Money {
  protected amount: number

  constructor(amount: number) {
    this.amount = amount
  }

  public equals(money: Money): boolean {
    if (money === null) {
      return false
    }

    return this.amount === money.amount
  }
}
