import Dollar from './Dollar'

export default class Money {
  public static dollar(amount: number): Money {
    return new Dollar(amount)
  }

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
