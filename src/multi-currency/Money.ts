export default class Money {
  protected amount: number

  constructor(amount: number) {
    this.amount = amount
  }

  public getClassName(): string {
    return (this as any).constructor.name
  }

  public equals(money: Money): boolean {
    if (money === null) {
      return false
    }

    if (this.getClassName() !== money.getClassName()) {
      return false
    }

    return this.amount === money.amount
  }
}
