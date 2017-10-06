import Money from './Money'

export default class France extends Money {
  constructor(amount: number) {
    super(amount)
  }

  public times(multiplications: number): Money {
    return new France(this.amount * multiplications)
  }
}
